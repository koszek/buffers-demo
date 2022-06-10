import com.example.flatbuffers.FBRoot;
import com.google.flatbuffers.FlatBufferBuilder;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class PartialDeserializeNestedFlat extends FlatBuffersTemplate<byte[]> {

    private int fieldCount;

    public PartialDeserializeNestedFlat(int fieldCount) {
        this.fieldCount = fieldCount;
    }

    @Override
    public List<byte[]> prepare() {
        List<Root> data = createRandomNestedObjects(OBJECT_COUNT);
        return serializeFlatAndReturn(data);
    }

    @Override
    public void doWork(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        FBRoot fbRoot = FBRoot.getRootAsFBRoot(byteBuffer);
        Root root = createRootPartial(fbRoot, fieldCount);
//        System.out.println(root);
    }

    private List<byte[]> serializeFlatAndReturn(List<Root> requests) {
        List<byte[]> result = new ArrayList<>(requests.size());
        for (Root root : requests) {
            result.add(serializeRequest(root, new FlatBufferBuilder(400)));
        }
        return result;
    }
}
