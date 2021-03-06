/*
 * Copyright 2010 Charles Chappell.
 *
 * This file is part of IcedJava.
 *
 * IcedJava is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * IcedJava is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with IcedJava.  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package net.mc_cubed.icedjava.ice;

import java.net.SocketException;
import javax.sdp.Media;
import javax.sdp.SdpException;
import javax.sdp.SdpParseException;
import net.mc_cubed.icedjava.ice.IceStateMachine.NominationType;

/**
 * Factory Class to create ICE types.
 *
 * @author Charles Chappell
 * @since 1.0
 */
public class IceFactory {

    /**
     * An IceSocket represents a media endpoint that can be used for sending and
     * receiving data to and from all peers connected to it, but has no actual
     * network existence.  All network functionality is encapsulated by an
     * ICE Peer.
     *
     * @return An uninitialized IceSocket object
     */
    public static IceSocket createIceSocket(Media media)
            throws SdpParseException, SocketException {
        if (media.getProtocol().startsWith("UDP")
                || media.getProtocol().startsWith("RTP")
                || media.getProtocol().startsWith("AVP")) {
            return new IceDatagramSocket(media);
        } else {
            return new IceStreamSocket(media);
        }
    }
        
    /**
     * Create an IcePeer not bound to any IceSockets
     * 
     * @return An initialized IcePeer without any sockets attached to it
     * @throws SdpException 
     */
    public static IcePeer createIcePeer() throws SdpException {
        return new IcePeerImpl();
    }

    /**
     * Create an IcePeer bound to the supplied sockets
     * 
     * @param sockets Sockets to bind the peer to
     * @return An initialized IcePeer bound to the supplied sockets
     * @throws SdpException 
     */
    public static IcePeer createIcePeer(IceSocket... sockets) throws SdpException {
        return new IcePeerImpl(sockets);
    }
    
    /**
     * Create a named IcePeer bound to the supplied sockets
     * 
     * @param peerId Name to assign the peer
     * @param sockets Sockets to bind the peer to
     * @return An initialized IcePeer bound to the supplied sockets
     * @throws SdpException 
     */
    public static IcePeer createIcePeer(String peerId,IceSocket... sockets) throws SdpException {
        return new IcePeerImpl(peerId,sockets);
    }

    /**
     * Create a named IcePeer bound to the supplied sockets
     * 
     * @param peerId Name to assign the peer
     * @param aggressive Use aggressive ICE nomination if true, regular nomination if false
     * @param sockets Sockets to bind the peer to
     * @return An initialized IcePeer bound to the supplied sockets
     * @throws SdpException 
     */
    public static IcePeer createIcePeer(String peerId,boolean aggressive,IceSocket... sockets) throws SdpException {
        return new IcePeerImpl(peerId,aggressive ? NominationType.AGGRESSIVE: NominationType.REGULAR,sockets);
    }

    private IceFactory() {
    }
    
    
}
