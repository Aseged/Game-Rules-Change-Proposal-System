CREATE TABLE "USERS" (
    "USERNAME" VARCHAR(100) not null primary key,
    "PASSWORD" VARCHAR(100) NOT NULL,
    "FULLNAME" VARCHAR(100) NOT NULL,
    "EMAIL" VARCHAR(100) NOT NULL,
    "COUNTRY" VARCHAR(100) NOT NULL,
    "ROLES" VARCHAR(20) NOT NULL,
	"STATUS" VARCHAR(100) NOT NULL,
	"LASTLOG" timestamp,
	"JOINED" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE "PROPOSALS" (
	"ID" INTEGER NOT NULL primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    "USERNAME" VARCHAR(100) NOT NULL,
    "TITLE" VARCHAR(100) NOT NULL,
    "DESCRIPTION" VARCHAR(2000) NOT NULL,
    "JUSTIFICATION" VARCHAR(2000) NOT NULL,
    "VOTESTATUS" VARCHAR(10) NOT NULL,
	"VOTEDEADLINE" TIMESTAMP,
	"PROPOSEDAT" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE "COMMENTS" (
	"COMMENTID" INTEGER not null primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    "ID" INTEGER not null,
	"USERNAME" VARCHAR(100) NOT NULL,
    "COMMENT" VARCHAR(2000) NOT NULL,
	"COMMENTEDAT" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE "VOTE" (
	"VOTEID" INTEGER not null primary key GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
		"ID" INTEGER NOT NULL,
	"USERNAME" VARCHAR(100) NOT NULL,
    "VOTE" VARCHAR(10) NOT NULL,
	"VOTEDAT" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
insert into users ( USERNAME, PASSWORD, FULLNAME, EMAIL, COUNTRY, ROLES, STATUS, LASTLOG) VALUES ('userAdmin', 'password', 'user admin', 'admin@admin.com', 'UK', 'admin', 'officer', CURRENT_TIMESTAMP);
insert into users ( USERNAME, PASSWORD, FULLNAME, EMAIL, COUNTRY, ROLES, STATUS, LASTLOG) VALUES ('userVoter', 'password', 'user voter', 'voter@admin.com', 'US', 'Voter', 'coach', CURRENT_TIMESTAMP);
insert into users ( USERNAME, PASSWORD, FULLNAME, EMAIL, COUNTRY, ROLES, STATUS, LASTLOG) VALUES ('userCommenter', 'password', 'user commenter', 'commenter@admin.com', 'UK', 'commenter', 'official', CURRENT_TIMESTAMP);
insert into users ( USERNAME, PASSWORD, FULLNAME, EMAIL, COUNTRY, ROLES, STATUS, LASTLOG) VALUES ('userUser', 'password', 'user user', 'user@admin.com', 'UK', 'user', 'player', CURRENT_TIMESTAMP);
insert into users ( USERNAME, PASSWORD, FULLNAME, EMAIL, COUNTRY, ROLES, STATUS, LASTLOG) VALUES ('userNotUser', 'password', 'user admin', 'admin@admin.com', 'US', '', 'player', CURRENT_TIMESTAMP);
insert into users ( USERNAME, PASSWORD, FULLNAME, EMAIL, COUNTRY, ROLES, STATUS, LASTLOG) VALUES ('userNotUser2', 'password', 'user admin', 'admin@admin.com', 'UK', '', 'player', CURRENT_TIMESTAMP);
insert into proposals ( USERNAME, TITLE, DESCRIPTION, JUSTIFICATION, VOTESTATUS, PROPOSEDAT) VALUES ('userAdmin', 'Tackling Rule Change', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eu urna at tortor sagittis dictum. Fusce feugiat, metus quis tincidunt sodales, diam mauris elementum turpis, sed venenatis massa magna eget augue. In rhoncus sodales neque vel congue. Quisque sagittis felis eget purus rhoncus, nec fringilla quam tincidunt. ', 'Proin blandit arcu ipsum, a pharetra arcu fermentum lobortis. Praesent venenatis sem ut leo commodo, vitae suscipit ante posuere. In quam mi, egestas in interdum et, ', 'closed', CURRENT_TIMESTAMP);
insert into proposals ( USERNAME, TITLE, DESCRIPTION, JUSTIFICATION, VOTESTATUS, PROPOSEDAT) VALUES ('userVoter', 'Score After Iligal Tackle', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eu urna at tortor sagittis dictum. Fusce feugiat, metus quis tincidunt sodales, diam mauris elementum turpis, sed venenatis massa magna eget augue. In rhoncus sodales neque vel congue. Quisque sagittis felis eget purus rhoncus, nec fringilla quam tincidunt. ', 'Proin blandit arcu ipsum, a pharetra arcu fermentum lobortis. Praesent venenatis sem ut leo commodo, vitae suscipit ante posuere. In quam mi, egestas in interdum et, ', 'Closed', CURRENT_TIMESTAMP);
insert into proposals ( USERNAME, TITLE, DESCRIPTION, JUSTIFICATION, VOTESTATUS, PROPOSEDAT) VALUES ('userCommenter', 'Tackling Rule Change', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eu urna at tortor sagittis dictum. Fusce feugiat, metus quis tincidunt sodales, diam mauris elementum turpis, sed venenatis massa magna eget augue. In rhoncus sodales neque vel congue. Quisque sagittis felis eget purus rhoncus, nec fringilla quam tincidunt. ', 'Proin blandit arcu ipsum, a pharetra arcu fermentum lobortis. Praesent venenatis sem ut leo commodo, vitae suscipit ante posuere. In quam mi, egestas in interdum et, ', 'Open', CURRENT_TIMESTAMP);
insert into proposals ( USERNAME, TITLE, DESCRIPTION, JUSTIFICATION, VOTESTATUS, PROPOSEDAT) VALUES ('userUser', 'Tackling Rule Change', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eu urna at tortor sagittis dictum. Fusce feugiat, metus quis tincidunt sodales, diam mauris elementum turpis, sed venenatis massa magna eget augue. In rhoncus sodales neque vel congue. Quisque sagittis felis eget purus rhoncus, nec fringilla quam tincidunt. ', 'Proin blandit arcu ipsum, a pharetra arcu fermentum lobortis. Praesent venenatis sem ut leo commodo, vitae suscipit ante posuere. In quam mi, egestas in interdum et, ', 'Open', CURRENT_TIMESTAMP);
insert into comments ( ID, USERNAME, COMMENT, COMMENTEDAT) VALUES (1, 'userAdmin', 'ullamcorper id massa. Vestibulum non sem velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; ',  CURRENT_TIMESTAMP);
insert into comments ( ID, USERNAME, COMMENT, COMMENTEDAT) VALUES (2, 'userVoter', 'ullamcorper id massa. Vestibulum non sem velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; ',  CURRENT_TIMESTAMP);
insert into comments ( ID, USERNAME, COMMENT, COMMENTEDAT) VALUES (3, 'userCommenter', 'ullamcorper id massa. Vestibulum non sem velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; ',  CURRENT_TIMESTAMP);
insert into comments ( ID, USERNAME, COMMENT, COMMENTEDAT) VALUES (4, 'userUser', 'ullamcorper id massa. Vestibulum non sem velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; ',  CURRENT_TIMESTAMP);
insert into comments ( ID, USERNAME, COMMENT, COMMENTEDAT) VALUES (1, 'userUser', 'ullamcorper id massa. Vestibulum non sem velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; ',  CURRENT_TIMESTAMP);
insert into comments ( ID, USERNAME, COMMENT, COMMENTEDAT) VALUES (2, 'userCommenter', 'ullamcorper id massa. Vestibulum non sem velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; ',  CURRENT_TIMESTAMP);
insert into comments ( ID, USERNAME, COMMENT, COMMENTEDAT) VALUES (3, 'userVoter', 'ullamcorper id massa. Vestibulum non sem velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; ',  CURRENT_TIMESTAMP);
insert into comments ( ID, USERNAME, COMMENT, COMMENTEDAT) VALUES (4, 'userAdmin', 'ullamcorper id massa. Vestibulum non sem velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; ',  CURRENT_TIMESTAMP);
insert into VOTE ( ID, USERNAME, VOTE, VOTEDAT) VALUES (1, 'userAdmin', 'For', CURRENT_TIMESTAMP);
insert into VOTE ( ID, USERNAME, VOTE, VOTEDAT) VALUES (2, 'userVoter', 'Against', CURRENT_TIMESTAMP);
insert into VOTE ( ID, USERNAME, VOTE, VOTEDAT) VALUES (3, 'userUser', 'For', CURRENT_TIMESTAMP);
insert into VOTE ( ID, USERNAME, VOTE, VOTEDAT) VALUES (4, 'userAdmin', 'For', CURRENT_TIMESTAMP);
insert into VOTE ( ID, USERNAME, VOTE, VOTEDAT) VALUES (1, 'userCommenter', 'Against', CURRENT_TIMESTAMP);
insert into VOTE ( ID, USERNAME, VOTE, VOTEDAT) VALUES (2, 'userCommenter', 'For', CURRENT_TIMESTAMP);
insert into VOTE ( ID, USERNAME, VOTE, VOTEDAT) VALUES (3, 'userVoter', 'Abstain', CURRENT_TIMESTAMP);
insert into VOTE ( ID, USERNAME, VOTE, VOTEDAT) VALUES (4, 'userUser', 'Abstain', CURRENT_TIMESTAMP);
ALTER TABLE PROPOSALS
ADD FOREIGN KEY (USERNAME) REFERENCES USERS(USERNAME);
ALTER TABLE COMMENTS
ADD FOREIGN KEY (USERNAME) REFERENCES USERS(USERNAME);
ALTER TABLE COMMENTS
ADD FOREIGN KEY (ID) REFERENCES PROPOSALS(ID);
ALTER TABLE VOTE
ADD FOREIGN KEY (USERNAME) REFERENCES USERS(USERNAME);
ALTER TABLE VOTE
ADD FOREIGN KEY (ID) REFERENCES PROPOSALS(ID);