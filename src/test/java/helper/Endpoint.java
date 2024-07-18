package helper;

public class Endpoint {

    public static final String HOST_GOREST = "https://gorest.co.in/public/v2/";
    public static final String GET_LIST_USERS = HOST_GOREST +"users";
    public static final String GET_LIST_USERS_ID = HOST_GOREST +"users";

    public static final String CREATE_NEW_USERS = HOST_GOREST +"users";
    public static final String DELETE_USERS = HOST_GOREST +"users";
    public static final String POST_USERS = HOST_GOREST +"users";

    public static final String PATCH_USERS = HOST_GOREST +"users";
    public static final String PUT_USERS = HOST_GOREST +"users";
    public static final String GET_DATA_WRONG_ID = HOST_GOREST + "users" + "/" + "1234567";

    public static final String HOST_QASE_IO = "https://api.qase.io/v1";
    public static final String QASE_API_TOKEN = "2b5590e8a6b7a751a147378f99408b2040f277b88385783a583e76e2f66b4ae7";
    public static final String PROJECT_CODE = "/BQ";
    public static final String TEST_RUN_CODE = "1";
}
