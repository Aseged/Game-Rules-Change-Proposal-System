package aseged.Entities;

import aseged.Entities.Comments;
import aseged.Entities.Proposals;
import aseged.Entities.Vote;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-31T22:34:18")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> country;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile CollectionAttribute<Users, Vote> voteCollection;
    public static volatile SingularAttribute<Users, Date> joined;
    public static volatile CollectionAttribute<Users, Proposals> proposalsCollection;
    public static volatile SingularAttribute<Users, String> roles;
    public static volatile SingularAttribute<Users, String> fullname;
    public static volatile CollectionAttribute<Users, Comments> commentsCollection;
    public static volatile SingularAttribute<Users, Date> lastlog;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> username;
    public static volatile SingularAttribute<Users, String> status;

}