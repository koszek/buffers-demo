import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class SerializePlainProto extends ProtoBuffersTemplate<Request> {

    @Override
    public List<Request> prepare() {
        return createRandomPlainObjects(OBJECT_COUNT);
    }

    @Override
    public void doWork(Request request) {
        try {
            createProtoRequest(request).writeTo(new ByteArrayOutputStream(400));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
