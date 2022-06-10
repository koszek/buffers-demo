import com.example.ProtoRequest;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DeserializePlainProto extends ProtoBuffersTemplate<byte[]> {

    @Override
    public List<byte[]> prepare() {
        List<Request> requests = createRandomPlainObjects(OBJECT_COUNT);
        return serializeProtoAndReturn(requests);

    }

    @Override
    public void doWork(byte[] bytes) {
        try {
            ProtoRequest.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    private List<byte[]> serializeProtoAndReturn(List<Request> requests) {
        List<byte[]> result = new ArrayList<>(requests.size());
        for (Request request : requests) {
            try {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream(400);
                createProtoRequest(request).writeTo(outputStream);
                result.add(outputStream.toByteArray());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
