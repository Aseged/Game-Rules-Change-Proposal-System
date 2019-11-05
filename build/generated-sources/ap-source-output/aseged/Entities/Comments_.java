package aseged.Entities;

import aseged.Entities.Proposals;
import aseged.Entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-31T22:34:18")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, Date> commentedat;
    public static volatile SingularAttribute<Comments, Integer> commentid;
    public static volatile SingularAttribute<Comments, String> comment;
    public static volatile SingularAttribute<Comments, Proposals> id;
    public static volatile SingularAttribute<Comments, Users> username;

}