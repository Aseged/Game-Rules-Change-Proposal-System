package aseged.Entities;

import aseged.Entities.Proposals;
import aseged.Entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-31T22:34:18")
@StaticMetamodel(Vote.class)
public class Vote_ { 

    public static volatile SingularAttribute<Vote, Date> votedat;
    public static volatile SingularAttribute<Vote, Integer> voteid;
    public static volatile SingularAttribute<Vote, Proposals> id;
    public static volatile SingularAttribute<Vote, String> vote;
    public static volatile SingularAttribute<Vote, Users> username;

}