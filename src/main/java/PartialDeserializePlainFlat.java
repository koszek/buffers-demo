import com.example.flatbuffers.FBRequest;
import com.google.flatbuffers.FlatBufferBuilder;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class PartialDeserializePlainFlat extends FlatBuffersTemplate<byte[]> {

    private int fieldCount;

    public PartialDeserializePlainFlat(int fieldCount) {
        this.fieldCount = fieldCount;
    }

    @Override
    public List<byte[]> prepare() {
        List<Request> requests = createRandomPlainObjects(OBJECT_COUNT);
        return serializeFlatAndReturn(requests);
    }

    @Override
    public void doWork(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        FBRequest fbRequest = FBRequest.getRootAsFBRequest(byteBuffer);
        createRequestPartial(fbRequest, fieldCount);
    }

    private Request createRequestPartial(FBRequest fbRequest, int fieldCount) {
        Request request = new Request();
        if (fieldCount >= 1) {
            request.setId(fbRequest.id());
        }
        if (fieldCount >= 2) {
            request.setName(fbRequest.name());
        }
        if (fieldCount >= 3) {
            request.setCode(fbRequest.code());
        }
        if (fieldCount >= 4) {
            request.setAccount(fbRequest.account());
        }
        if (fieldCount >= 5) {
            request.setBrokerAccount(fbRequest.brokerAccount());
        }
        if (fieldCount >= 6) {
            request.setCountry(fbRequest.country());
        }
        if (fieldCount >= 7) {
            request.setRequestType(RequestType.values()[fbRequest.requestType()]);
        }
        if (fieldCount >= 8) {
            request.setQuantity(fbRequest.quantity());
        }
        if (fieldCount >= 9) {
            request.setPrice(fbRequest.price());
        }
        if (fieldCount >= 10) {
            request.setIsProcessed(fbRequest.isProcessed());
        }
        if (fieldCount >= 11) {
            request.setDate(fbRequest.date());
        }
        if (fieldCount >= 12) {
            request.setOldId(fbRequest.oldId());
        }
        if (fieldCount >= 13) {
            request.setRegion(fbRequest.region());
        }
        if (fieldCount >= 14) {
            request.setStatus(Status.values()[fbRequest.status()]);
        }
        if (fieldCount >= 15) {
            request.setClientName(fbRequest.clientName());
        }
        if (fieldCount >= 16) {
            request.setStatusReason(fbRequest.statusReason());
        }
        if (fieldCount >= 17) {
            request.setCommission(fbRequest.commission());
        }
        if (fieldCount >= 18) {
            request.setFee(fbRequest.fee());
        }
        if (fieldCount >= 19) {
            request.setAlgorithm(fbRequest.algorith());
        }
        if (fieldCount >= 20) {
            request.setInstructions(fbRequest.instructins());
        }
        return request;
    }

    private List<byte[]> serializeFlatAndReturn(List<Request> requests) {
        List<byte[]> result = new ArrayList<>(requests.size());
        for (Request request : requests) {
            result.add(serializeRequest(request, new FlatBufferBuilder(400)));
        }
        return result;
    }
}
