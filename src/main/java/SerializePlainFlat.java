import com.google.flatbuffers.FlatBufferBuilder;

import java.util.List;

public class SerializePlainFlat extends FlatBuffersTemplate<Request> {

    @Override
    public List<Request> prepare() {
        return createRandomPlainObjects(OBJECT_COUNT);
    }

    @Override
    public void doWork(Request request) {
        serializeRequest(request, new FlatBufferBuilder(400));
    }
}
