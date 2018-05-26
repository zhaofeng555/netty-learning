package org.lwl.netty.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwl.netty.message.ProtocolMessage;
import org.lwl.netty.message.body.LoginReqBody;
import org.lwl.netty.message.body.ProtocolSubBody;

/**
 * @author thinking_fioa
 * @createTime 2018/5/24
 * @description Protocol消息订阅和接收服务
 */

public class ProtocolMsgSubHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LogManager.getLogger(ProtocolMsgSubHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ProtocolMessage ptclSubMsg = buildPtclSubMsg();
        LOGGER.info("MsgSub active. protocl msg sub sent");
        ctx.writeAndFlush(ptclSubMsg);
    }

    private ProtocolMessage buildPtclSubMsg() {
        ProtocolSubBody subBody = new ProtocolSubBody();
        // TODO:: 补充字段属性

        return ProtocolMessage.createMsgOfEncode(subBody);
    }
}
