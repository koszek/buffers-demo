import com.example.flatbuffers.FBRequest;
import com.google.flatbuffers.FlatBufferBuilder;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class DeserializePlainFlat extends FlatBuffersTemplate<byte[]> {

    @Override
    public List<byte[]> prepare() {
        List<Request> requests = createRandomPlainObjects(OBJECT_COUNT);
        return serializeFlatAndReturn(requests);
    }

    @Override
    public void doWork(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        FBRequest fbRequest = FBRequest.getRootAsFBRequest(byteBuffer);
        createRequest(fbRequest);
    }

    private List<byte[]> serializeFlatAndReturn(List<Request> requests) {
        List<byte[]> result = new ArrayList<>(requests.size());
        for (Request request : requests) {
            result.add(serializeRequest(request, new FlatBufferBuilder(400)));
        }
        return result;
    }
}
