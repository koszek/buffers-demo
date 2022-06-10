import com.example.*;

public abstract class ProtoBuffersTemplate<T> extends Template<T> {

    protected ProtoRequest createProtoRequest(Request request) {
        return ProtoRequest.newBuilder()
                .setId(request.getId())
                .setName(request.getName())
                .setCode(request.getCode())
                .setAccount(request.getAccount())
                .setBrokerAccount(request.getBrokerAccount())
                .setCountry(request.getCountry())
                .setRequestType(ProtoRequestType.valueOf(request.getRequestType().name()))
                .setQuantity(request.getQuantity())
                .setPrice(request.getPrice())
                .setIsProcessed(request.getIsProcessed())
                .setDate(request.getDate())
                .setOldId(request.getOldId())
                .setClientName(request.getClientName())
                .setRegion(request.getRegion())
                .setStatus(ProtoStatus.valueOf(request.getStatus().name()))
                .setStatusReason(request.getStatusReason())
                .setCommission(request.getCommission())
                .setFee(request.getFee())
                .setAlgorithm(request.getAlgorithm())
                .setInstructions(request.getInstructions())
                .build();
    }

    protected ProtoRoot createProtoRequest(Root request) {
        return ProtoRoot.newBuilder()
                .setField1(request.getField1())
                .setField2(request.getField2())
                .setField3(request.getField3())
                .setNested1(createProtoNested(request.getNested1()))
                .setNested2(createProtoNested(request.getNested2()))
                .setNested3(createProtoNested(request.getNested3()))
                .build();
    }

    private ProtoNested createProtoNested(Nested nested) {
        return ProtoNested.newBuilder()
                .setField1(nested.getField1())
                .setField2(nested.getField2())
                .setField3(nested.getField3())
                .setInner1(createProtoInner(nested.getInner1()))
                .setInner2(createProtoInner(nested.getInner2()))
                .build();
    }

    private ProtoInner createProtoInner(Inner inner) {
        return ProtoInner.newBuilder()
                .setField1(inner.getField1())
                .setField2(inner.getField2())
                .setField3(inner.getField3())
                .setDeep1(createProtoDeep(inner.getDeep1()))
                .setDeep2(createProtoDeep(inner.getDeep2()))
                .build();
    }

    private ProtoDeep createProtoDeep(Deep deep) {
        return ProtoDeep.newBuilder()
                .setField1(deep.getField1())
                .setField2(deep.getField2())
                .build();
    }
}
