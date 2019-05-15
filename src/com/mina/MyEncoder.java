package com.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class MyEncoder extends CumulativeProtocolDecoder {
    @Override
    protected boolean doDecode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
        if (ioBuffer.remaining() > 0) {
            byte[] buf = new byte[ioBuffer.remaining()];
            ioBuffer.get(buf);
            protocolDecoderOutput.write(new String(buf, "UTF-8"));
            return true;
        } else {
            return false;
        }
    }
}
