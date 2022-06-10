public class Request {

    private long id;
    private String name;
    private String code;
    private String account;
    private String brokerAccount;
    private String country;
    private RequestType requestType;
    private int quantity;
    private float price;
    private boolean isProcessed;
    private String date;
    private long oldId;
    private String clientName;
    private String region;
    private Status status;
    private String statusReason;
    private double commission;
    private double fee;
    private String algorithm;
    private String instructions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBrokerAccount() {
        return brokerAccount;
    }

    public void setBrokerAccount(String brokerAccount) {
        this.brokerAccount = brokerAccount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(boolean processed) {
        isProcessed = processed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getOldId() {
        return oldId;
    }

    public void setOldId(long oldId) {
        this.oldId = oldId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", account='" + account + '\'' +
                ", brokerAccount='" + brokerAccount + '\'' +
                ", country='" + country + '\'' +
                ", requestType=" + requestType +
                ", quantity=" + quantity +
                ", price=" + price +
                ", isProcessed=" + isProcessed +
                ", date='" + date + '\'' +
                ", oldId=" + oldId +
                ", clientName='" + clientName + '\'' +
                ", region='" + region + '\'' +
                ", status=" + status +
                ", statusReason='" + statusReason + '\'' +
                ", commission=" + commission +
                ", fee=" + fee +
                ", algorithm='" + algorithm + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
