import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class SerializeNestedProto extends ProtoBuffersTemplate<Root> {

    @Override
    public List<Root> prepare() {
        return createRandomNestedObjects(OBJECT_COUNT);
    }

    @Override
    public void doWork(Root request) {
        try {
            createProtoRequest(request).writeTo(new ByteArrayOutputStream(400));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
