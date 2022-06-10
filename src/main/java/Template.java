import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Template<T> {

    protected static final int OBJECT_COUNT = 200000;

    protected final Random random;

    public Template() {
        random = new Random(System.currentTimeMillis());
    }

    public abstract List<T> prepare();

    public abstract void doWork(T data);

    public long run() {
        List<T> data = prepare();
        long time = System.currentTimeMillis();
        for (T t : data) {
            doWork(t);
        }
        return System.currentTimeMillis() - time;
    }

    public List<Request> createRandomPlainObjects(int size) {
        List<Request> objects = new ArrayList<>(size);
        for (int i = 0; i < size - 1; i++) {
            objects.add(createRandomPlainObject());
        }
        return objects;
    }

    public Request createRandomPlainObject() {
        Request request = new Request();
        request.setId(random.nextLong());
        request.setName(randomString(10));
        request.setCode(randomString(6));
        request.setAccount(randomString(20));
        request.setBrokerAccount(randomString(20));
        request.setCountry(randomString(7));
        request.setRequestType(randomRequestType());
        request.setQuantity(random.nextInt());
        request.setPrice(random.nextFloat());
        request.setIsProcessed(random.nextBoolean());
        request.setDate(randomString(8));
        request.setOldId(random.nextLong());
        request.setClientName(randomString(10));
        request.setRegion(randomString(6));
        request.setStatus(randomStatus());
        request.setStatusReason(randomString(100));
        request.setCommission(random.nextDouble());
        request.setFee(random.nextDouble());
        request.setAlgorithm(randomString(20));
        request.setInstructions(randomString(100));
        return request;
    }


    public List<Root> createRandomNestedObjects(int size) {
        List<Root> objects = new ArrayList<>(size);
        for (int i = 0; i < size - 1; i++) {
            objects.add(createRandomNestedObject());
        }
        return objects;
    }

    public Root createRandomNestedObject() {
        Root root = new Root();
        root.setField1(randomString(20));
        root.setField2(randomString(20));
        root.setField3(randomString(20));
        root.setNested1(createRandomNested());
        root.setNested2(createRandomNested());
        root.setNested3(createRandomNested());
        return root;
    }

    private Nested createRandomNested() {
        Nested nested = new Nested();
        nested.setField1(randomString(20));
        nested.setField2(randomString(20));
        nested.setField3(randomString(20));
        nested.setInner1(createRandomInner());
        nested.setInner2(createRandomInner());
        return nested;
    }

    private Inner createRandomInner() {
        Inner inner = new Inner();
        inner.setField1(randomString(20));
        inner.setField2(randomString(20));
        inner.setField3(randomString(20));
        inner.setDeep1(createRandomDeep());
        inner.setDeep2(createRandomDeep());
        return inner;
    }

    private Deep createRandomDeep() {
        Deep deep = new Deep();
        deep.setField1(randomString(20));
        deep.setField2(randomString(20));
        return deep;
    }

    protected RequestType randomRequestType() {
        return RequestType.values()[random.nextInt(RequestType.values().length)];
    }

    protected Status randomStatus() {
        return Status.values()[random.nextInt(Status.values().length)];
    }

    public String randomString(int length) {
        int leftLimit = 97;
        int rightLimit = 122;

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    protected String randomStringOld(int length) {
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) random.nextInt(120);
        }
        return new String(chars);
    }
}
