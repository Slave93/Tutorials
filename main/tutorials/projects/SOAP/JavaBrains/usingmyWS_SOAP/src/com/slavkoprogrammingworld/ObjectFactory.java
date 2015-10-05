
package com.slavkoprogrammingworld;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.slavkoprogrammingworld package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SetNewUserObj_QNAME = new QName("http://SlavkoProgrammingWorld.com", "setNewUserObj");
    private final static QName _SetNewUserResponse_QNAME = new QName("http://SlavkoProgrammingWorld.com", "setNewUserResponse");
    private final static QName _GetUsersResponse_QNAME = new QName("http://SlavkoProgrammingWorld.com", "getUsersResponse");
    private final static QName _NoUserWithSuchIDException_QNAME = new QName("http://SlavkoProgrammingWorld.com", "NoUserWithSuchIDException");
    private final static QName _SetNewUserObjResponse_QNAME = new QName("http://SlavkoProgrammingWorld.com", "setNewUserObjResponse");
    private final static QName _GetUserNameById_QNAME = new QName("http://SlavkoProgrammingWorld.com", "getUserNameById");
    private final static QName _GetUserNameByIdResponse_QNAME = new QName("http://SlavkoProgrammingWorld.com", "getUserNameByIdResponse");
    private final static QName _SetNewUsers_QNAME = new QName("http://SlavkoProgrammingWorld.com", "setNewUsers");
    private final static QName _GetUsers_QNAME = new QName("http://SlavkoProgrammingWorld.com", "getUsers");
    private final static QName _User_QNAME = new QName("http://SlavkoProgrammingWorld.com", "User");
    private final static QName _SetNewUser_QNAME = new QName("http://SlavkoProgrammingWorld.com", "setNewUser");
    private final static QName _SetNewUsersResponse_QNAME = new QName("http://SlavkoProgrammingWorld.com", "setNewUsersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.slavkoprogrammingworld
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link SetNewUser }
     * 
     */
    public SetNewUser createSetNewUser() {
        return new SetNewUser();
    }

    /**
     * Create an instance of {@link SetNewUsersResponse }
     * 
     */
    public SetNewUsersResponse createSetNewUsersResponse() {
        return new SetNewUsersResponse();
    }

    /**
     * Create an instance of {@link SetNewUserObjResponse }
     * 
     */
    public SetNewUserObjResponse createSetNewUserObjResponse() {
        return new SetNewUserObjResponse();
    }

    /**
     * Create an instance of {@link GetUsers }
     * 
     */
    public GetUsers createGetUsers() {
        return new GetUsers();
    }

    /**
     * Create an instance of {@link GetUserNameById }
     * 
     */
    public GetUserNameById createGetUserNameById() {
        return new GetUserNameById();
    }

    /**
     * Create an instance of {@link GetUserNameByIdResponse }
     * 
     */
    public GetUserNameByIdResponse createGetUserNameByIdResponse() {
        return new GetUserNameByIdResponse();
    }

    /**
     * Create an instance of {@link SetNewUsers }
     * 
     */
    public SetNewUsers createSetNewUsers() {
        return new SetNewUsers();
    }

    /**
     * Create an instance of {@link NoUserWithSuchIDException }
     * 
     */
    public NoUserWithSuchIDException createNoUserWithSuchIDException() {
        return new NoUserWithSuchIDException();
    }

    /**
     * Create an instance of {@link SetNewUserObj }
     * 
     */
    public SetNewUserObj createSetNewUserObj() {
        return new SetNewUserObj();
    }

    /**
     * Create an instance of {@link GetUsersResponse }
     * 
     */
    public GetUsersResponse createGetUsersResponse() {
        return new GetUsersResponse();
    }

    /**
     * Create an instance of {@link SetNewUserResponse }
     * 
     */
    public SetNewUserResponse createSetNewUserResponse() {
        return new SetNewUserResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNewUserObj }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SlavkoProgrammingWorld.com", name = "setNewUserObj")
    public JAXBElement<SetNewUserObj> createSetNewUserObj(SetNewUserObj value) {
        return new JAXBElement<SetNewUserObj>(_SetNewUserObj_QNAME, SetNewUserObj.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNewUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SlavkoProgrammingWorld.com", name = "setNewUserResponse")
    public JAXBElement<SetNewUserResponse> createSetNewUserResponse(SetNewUserResponse value) {
        return new JAXBElement<SetNewUserResponse>(_SetNewUserResponse_QNAME, SetNewUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SlavkoProgrammingWorld.com", name = "getUsersResponse")
    public JAXBElement<GetUsersResponse> createGetUsersResponse(GetUsersResponse value) {
        return new JAXBElement<GetUsersResponse>(_GetUsersResponse_QNAME, GetUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoUserWithSuchIDException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SlavkoProgrammingWorld.com", name = "NoUserWithSuchIDException")
    public JAXBElement<NoUserWithSuchIDException> createNoUserWithSuchIDException(NoUserWithSuchIDException value) {
        return new JAXBElement<NoUserWithSuchIDException>(_NoUserWithSuchIDException_QNAME, NoUserWithSuchIDException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNewUserObjResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SlavkoProgrammingWorld.com", name = "setNewUserObjResponse")
    public JAXBElement<SetNewUserObjResponse> createSetNewUserObjResponse(SetNewUserObjResponse value) {
        return new JAXBElement<SetNewUserObjResponse>(_SetNewUserObjResponse_QNAME, SetNewUserObjResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserNameById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SlavkoProgrammingWorld.com", name = "getUserNameById")
    public JAXBElement<GetUserNameById> createGetUserNameById(GetUserNameById value) {
        return new JAXBElement<GetUserNameById>(_GetUserNameById_QNAME, GetUserNameById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserNameByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SlavkoProgrammingWorld.com", name = "getUserNameByIdResponse")
    public JAXBElement<GetUserNameByIdResponse> createGetUserNameByIdResponse(GetUserNameByIdResponse value) {
        return new JAXBElement<GetUserNameByIdResponse>(_GetUserNameByIdResponse_QNAME, GetUserNameByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNewUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SlavkoProgrammingWorld.com", name = "setNewUsers")
    public JAXBElement<SetNewUsers> createSetNewUsers(SetNewUsers value) {
        return new JAXBElement<SetNewUsers>(_SetNewUsers_QNAME, SetNewUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SlavkoProgrammingWorld.com", name = "getUsers")
    public JAXBElement<GetUsers> createGetUsers(GetUsers value) {
        return new JAXBElement<GetUsers>(_GetUsers_QNAME, GetUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SlavkoProgrammingWorld.com", name = "User")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNewUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SlavkoProgrammingWorld.com", name = "setNewUser")
    public JAXBElement<SetNewUser> createSetNewUser(SetNewUser value) {
        return new JAXBElement<SetNewUser>(_SetNewUser_QNAME, SetNewUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNewUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SlavkoProgrammingWorld.com", name = "setNewUsersResponse")
    public JAXBElement<SetNewUsersResponse> createSetNewUsersResponse(SetNewUsersResponse value) {
        return new JAXBElement<SetNewUsersResponse>(_SetNewUsersResponse_QNAME, SetNewUsersResponse.class, null, value);
    }

}
