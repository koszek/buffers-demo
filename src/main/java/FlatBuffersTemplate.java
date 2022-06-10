import com.example.flatbuffers.*;
import com.google.flatbuffers.FlatBufferBuilder;

public abstract class FlatBuffersTemplate<T> extends Template<T> {

    protected Request createRequest(FBRequest fbRequest) {
        Request request = new Request();
        request.setId(fbRequest.id());
        request.setName(fbRequest.name());
        request.setCode(fbRequest.code());
        request.setAccount(fbRequest.account());
        request.setBrokerAccount(fbRequest.brokerAccount());
        request.setCountry(fbRequest.country());
        request.setRequestType(RequestType.values()[fbRequest.requestType()]);
        request.setQuantity(fbRequest.quantity());
        request.setPrice(fbRequest.price());
        request.setIsProcessed(fbRequest.isProcessed());
        request.setDate(fbRequest.date());
        request.setOldId(fbRequest.oldId());
        request.setClientName(fbRequest.clientName());
        request.setRegion(fbRequest.region());
        request.setStatus(Status.values()[fbRequest.status()]);
        request.setStatusReason(fbRequest.statusReason());
        request.setCommission(fbRequest.commission());
        request.setFee(fbRequest.fee());
        request.setAlgorithm(fbRequest.algorith());
        request.setInstructions(fbRequest.instructins());
        return request;
    }

    protected Root createRootPartial(FBRoot fbRoot, int fieldCount) {
        Root root = new Root();
        if (fieldCount >= 1) {
            root.setField1(fbRoot.field1());
        }
        if (fieldCount >= 2) {
            Nested nested1 = new Nested();
            nested1.setField1(fbRoot.nested1().field1());
            root.setNested1(nested1);
        }
        if (fieldCount >= 3) {
            Inner inner = new Inner();
            inner.setField1(fbRoot.nested1().inner1().field1());
            root.getNested1().setInner1(inner);
        }
        if (fieldCount >=4) {
            Deep deep = new Deep();
            deep.setField1(fbRoot.nested1().inner1().deep1().field1());
            root.getNested1().getInner1().setDeep1(deep);
        }

        return root;
    }

    protected Root createRoot(FBRoot fbRoot) {
        Root root = new Root();
        root.setField1(fbRoot.field1());
        root.setField2(fbRoot.field2());
        root.setField3(fbRoot.field3());
        root.setNested1(createNested(fbRoot.nested1()));
        root.setNested2(createNested(fbRoot.nested2()));
        root.setNested3(createNested(fbRoot.nested3()));
        return root;
    }

    private Nested createNested(FBNested fbNested) {
        Nested nested = new Nested();
        nested.setField1(fbNested.field1());
        nested.setField2(fbNested.field2());
        nested.setField3(fbNested.field3());
        nested.setInner1(createInner(fbNested.inner1()));
        nested.setInner2(createInner(fbNested.inner2()));
        return nested;
    }

    private Inner createInner(FBInner fbInner) {
        Inner inner = new Inner();
        inner.setField1(fbInner.field1());
        inner.setField2(fbInner.field2());
        inner.setField3(fbInner.field3());
        inner.setDeep1(createDeep(fbInner.deep1()));
        inner.setDeep2(createDeep(fbInner.deep2()));
        return inner;
    }

    private Deep createDeep(FBDeep fbDeep) {
        Deep deep = new Deep();
        deep.setField1(fbDeep.field1());
        deep.setField2(fbDeep.field2());
        return deep;
    }

    protected byte[] serializeRequest(Request request, FlatBufferBuilder builder) {
        int name = builder.createString(request.getName());
        int code = builder.createString(request.getCode());
        int account = builder.createString(request.getAccount());
        int brokerAccount = builder.createString(request.getBrokerAccount());
        int country = builder.createString(request.getCountry());
        int date = builder.createString(request.getDate());
        int clientName = builder.createString(request.getClientName());
        int region = builder.createString(request.getRegion());
        int statusReason = builder.createString(request.getStatusReason());
        int algorithm = builder.createString(request.getAlgorithm());
        int instructions = builder.createString(request.getInstructions());

        FBRequest.startFBRequest(builder);
        FBRequest.addId(builder, request.getId());
        FBRequest.addName(builder, name);
        FBRequest.addCode(builder, code);
        FBRequest.addAccount(builder, account);
        FBRequest.addBrokerAccount(builder, brokerAccount);
        FBRequest.addCountry(builder, country);
        FBRequest.addRequestType(builder, (byte) request.getRequestType().ordinal());
        FBRequest.addQuantity(builder, request.getQuantity());
        FBRequest.addPrice(builder, request.getPrice());
        FBRequest.addIsProcessed(builder, request.getIsProcessed());
        FBRequest.addBrokerAccount(builder, date);
        FBRequest.addOldId(builder, request.getOldId());
        FBRequest.addClientName(builder, clientName);
        FBRequest.addRegion(builder, region);
        FBRequest.addStatus(builder, (byte) request.getStatus().ordinal());
        FBRequest.addRegion(builder, statusReason);
        FBRequest.addCommission(builder, request.getCommission());
        FBRequest.addFee(builder, request.getFee());
        FBRequest.addAlgorith(builder, algorithm);
        FBRequest.addInstructins(builder, instructions);
        int fbRequest = FBRequest.endFBRequest(builder);
        builder.finish(fbRequest);
        return builder.sizedByteArray();
    }

    protected byte[] serializeRequest(Root root, FlatBufferBuilder builder) {
        int field1 = builder.createString(root.getField1());
        int field2 = builder.createString(root.getField2());
        int field3 = builder.createString(root.getField3());
        int nested1 = createNested(root.getNested1(), builder);
        int nested2 = createNested(root.getNested2(), builder);
        int nested3 = createNested(root.getNested3(), builder);

        FBRoot.startFBRoot(builder);
        FBRoot.addField1(builder, field1);
        FBRoot.addField2(builder, field2);
        FBRoot.addField3(builder, field3);
        FBRoot.addNested1(builder, nested1);
        FBRoot.addNested2(builder, nested2);
        FBRoot.addNested3(builder, nested3);

        int fbRoot = FBRoot.endFBRoot(builder);
        builder.finish(fbRoot);
        return builder.sizedByteArray();
    }

    private int createNested(Nested nested, FlatBufferBuilder builder) {
        int field1 = builder.createString(nested.getField1());
        int field2 = builder.createString(nested.getField2());
        int field3 = builder.createString(nested.getField3());
        int inner1 = createInner(nested.getInner1(), builder);
        int inner2 = createInner(nested.getInner2(), builder);
        return FBNested.createFBNested(builder, field1, field2, field3, inner1, inner2);
    }

    private int createInner(Inner inner, FlatBufferBuilder builder) {
        int field1 = builder.createString(inner.getField1());
        int field2 = builder.createString(inner.getField2());
        int field3 = builder.createString(inner.getField3());
        int deep1 = createDeep(inner.getDeep1(), builder);
        int deep2 = createDeep(inner.getDeep2(), builder);
        return FBInner.createFBInner(builder, field1, field2, field3, deep1, deep2);
    }

    private int createDeep(Deep deep, FlatBufferBuilder builder) {
        int field1 = builder.createString(deep.getField1());
        int field2 = builder.createString(deep.getField2());
        return FBDeep.createFBDeep(builder, field1, field2);
    }
}
