package common;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * description: RPC 解码器
 * @author coin
 * @date 2019/06/02 23:08
 * @version 1.0
 */
public class RpcDecoder extends ByteToMessageDecoder {

    private Class<?> genericClass;

	// 构造函数传入向反序列化的class
    public RpcDecoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    public final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        /*
        in.markReaderIndex();
        int dataLength = in.readInt();
        if (dataLength < 0) {
            ctx.close();
        }
        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
        }*/
        
        //将ByteBuf转换为byte[]
        int dataLength = in.readInt();
        byte[] data = new byte[dataLength];
        in.readBytes(data);
        in.clear();
        //将data转换成object ，就是拿到客户端发过来的RpcRequest对象
        Object obj = SerializationUtil.deserialize(data, genericClass);
        
        // 将RpcRequest对象发往下一个inboundhandler去做业务调用
        out.add(obj);
    }
}
