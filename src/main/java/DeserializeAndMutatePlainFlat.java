import com.example.flatbuffers.FBRequest;
import com.google.flatbuffers.FlatBufferBuilder;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeserializeAndMutatePlainFlat extends FlatBuffersTemplate<byte[]> {

    @Override
    public List<byte[]> prepare() {
        List<Request> requests = createRandomPlainObjects(10);
        return serializeFlatAndReturn(requests);
    }

    @Override
    public void doWork(byte[] bytes) {
        System.out.println("length " + bytes.length);
        System.out.println(Arrays.toString(bytes));
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        FBRequest fbRequest = FBRequest.getRootAsFBRequest(byteBuffer);
//        fbRequest.mutateId(random.nextLong());
//        fbRequest.mutateCommission(1d);
        System.out.println("length " + bytes.length);
        System.out.println(Arrays.toString(bytes));
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
