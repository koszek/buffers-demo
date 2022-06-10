import com.example.ProtoRoot;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DeserializeNestedProto extends ProtoBuffersTemplate<byte[]> {

    @Override
    public List<byte[]> prepare() {
        List<Root> objects = createRandomNestedObjects(OBJECT_COUNT);
        return serializeProtoAndReturn(objects);
    }

    @Override
    public void doWork(byte[] bytes) {
        try {
            ProtoRoot.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    private List<byte[]> serializeProtoAndReturn(List<Root> requests) {
        List<byte[]> result = new ArrayList<>(requests.size());
        for (Root root : requests) {
            try {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream(400);
                createProtoRequest(root).writeTo(outputStream);
                result.add(outputStream.toByteArray());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
