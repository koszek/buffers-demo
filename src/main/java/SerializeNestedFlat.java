import com.google.flatbuffers.FlatBufferBuilder;

import java.util.List;

public class SerializeNestedFlat extends FlatBuffersTemplate<Root> {

    @Override
    public List<Root> prepare() {
        return createRandomNestedObjects(OBJECT_COUNT);
    }

    @Override
    public void doWork(Root request) {
        serializeRequest(request, new FlatBufferBuilder(400));
    }
}
