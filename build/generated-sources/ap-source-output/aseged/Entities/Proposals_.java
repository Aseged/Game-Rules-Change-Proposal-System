package aseged.Entities;

import aseged.Entities.Comments;
import aseged.Entities.Users;
import aseged.Entities.Vote;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-31T22:34:18")
@StaticMetamodel(Proposals.class)
public class Proposals_ { 

    public static volatile CollectionAttribute<Proposals, Vote> voteCollection;
    public static volatile SingularAttribute<Proposals, Date> votedeadline;
    public static volatile SingularAttribute<Proposals, String> description;
    public static volatile SingularAttribute<Proposals, Integer> id;
    public static volatile SingularAttribute<Proposals, String> justification;
    public static volatile CollectionAttribute<Proposals, Comments> commentsCollection;
    public static volatile SingularAttribute<Proposals, String> title;
    public static volatile SingularAttribute<Proposals, Date> proposedat;
    public static volatile SingularAttribute<Proposals, String> votestatus;
    public static volatile SingularAttribute<Proposals, Users> username;

}