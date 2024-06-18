package enums;

public enum Algorithm {
    SHA1_WITH_RSA("SHA1withRSA"),
    SHA1("SHA-1"),
    SHA128("SHA-256"),
    AES("AES"),
    RSA("RSA"),
    AES_LENGTH("128");
    
    private String algorithm;
    
    Algorithm(String algorithm){
        this.algorithm = algorithm;
    }
    
    public String getAlgorithm() {
        return algorithm;
    }
}
