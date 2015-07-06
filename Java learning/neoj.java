package test;

import java.io.File;
import java.io.IOException;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.io.fs.FileUtils;



public class neoj
{
    private static final String DB_PATH = "DingchaoZhang";

    public String greeting;

    // START SNIPPET: vars
    GraphDatabaseService graphDb;
    Node firstNode;
    Node secondNode;
    Node thirdNode;
    Node fourthNode;
    Node fifthNode;
    Node sixthNode;
    Node seventhNode;
    Node eighthNode;
    Node ninthNode;
    Node tenthNode;

    Relationship relationship;
    Relationship relationship2;
   
    // END SNIPPET: vars

    // START SNIPPET: createReltype
    private static enum RelTypes implements RelationshipType
    {
        KNOWS
    }
    // END SNIPPET: createReltype

    public static void main( final String[] args ) throws IOException
    {
        neoj hello = new neoj();
        hello.createDb();
        hello.removeData();
        hello.shutDown();
        
        // delete db
        FileUtils.deleteRecursively( new File( DB_PATH ) );
        System.out.print( "deleting db\n" );
        
    }

    void createDb() throws IOException
    {
        FileUtils.deleteRecursively( new File( DB_PATH ) );

        // START SNIPPET: startDb
        graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );
        registerShutdownHook( graphDb );
        // END SNIPPET: startDb

        // START SNIPPET: transaction
        try ( Transaction tx = graphDb.beginTx() )
        {
            // Database operations go here
            // END SNIPPET: transaction
            // START SNIPPET: addData
            firstNode = graphDb.createNode();
            firstNode.setProperty( "title", "book1" );
            firstNode.setProperty( "author", "author1" );
            firstNode.setProperty( "year", "1991" );
            secondNode = graphDb.createNode();
            secondNode.setProperty( "title", "book2" );
            secondNode.setProperty( "author", "author2" );
            secondNode.setProperty( "year", "1992" );
            thirdNode = graphDb.createNode();
            thirdNode.setProperty( "title", "book3" );
            thirdNode.setProperty( "author", "author3" );
            thirdNode.setProperty( "year", "1993" );
            fourthNode = graphDb.createNode();
            fourthNode.setProperty( "title", "book4" );
            fourthNode.setProperty( "author", "author4" );
            fourthNode.setProperty( "year", "1994" );
            fifthNode = graphDb.createNode();
            fifthNode.setProperty( "title", "book5" );
            fifthNode.setProperty( "author", "author5" );
            fifthNode.setProperty( "year", "1995" );
            sixthNode = graphDb.createNode();
            sixthNode.setProperty( "title", "book6" );
            sixthNode.setProperty( "author", "author6" );
            sixthNode.setProperty( "year", "1996" );
            seventhNode = graphDb.createNode();
            seventhNode.setProperty( "title", "book7" );
            seventhNode.setProperty( "author", "author7" );
            seventhNode.setProperty( "year", "1997" );
            eighthNode = graphDb.createNode();
            eighthNode.setProperty( "title", "book8" );
            eighthNode.setProperty( "author", "author8" );
            eighthNode.setProperty( "year", "1998" );
            ninthNode = graphDb.createNode();
            ninthNode.setProperty( "title", "book9" );
            ninthNode.setProperty( "author", "author9" );
            ninthNode.setProperty( "year", "1999" );
            tenthNode = graphDb.createNode();
            tenthNode.setProperty( "title", "book10" );
            tenthNode.setProperty( "author", "author10" );
            tenthNode.setProperty( "year", "2000" );

            relationship = firstNode.createRelationshipTo( secondNode, RelTypes.KNOWS );
            relationship.setProperty( "message", "brave Neo4j " );
            relationship2 = ninthNode.createRelationshipTo( sixthNode, RelTypes.KNOWS );
            relationship2.setProperty( "message", "what's up " );
            // END SNIPPET: addData

            // START SNIPPET: readData
            System.out.print( firstNode.getProperty( "title" ) + "\n" );
            System.out.print( firstNode.getProperty( "author" )  + "\n" );
            System.out.print( firstNode.getProperty( "year" ) + "\n"  );
            System.out.print( secondNode.getProperty( "title" ) + "\n"  );
            System.out.print( secondNode.getProperty( "author" )  + "\n" );
            System.out.print( secondNode.getProperty( "year" ) + "\n"  );
            System.out.print( thirdNode.getProperty( "title" )  + "\n" );
            System.out.print( thirdNode.getProperty( "author" )  + "\n" );
            System.out.print( thirdNode.getProperty( "year" ) + "\n"  );
            System.out.print( fourthNode.getProperty( "title" ) + "\n"  );
            System.out.print( fourthNode.getProperty( "author" ) + "\n"  );
            System.out.print( fourthNode.getProperty( "year" )  + "\n" );
            System.out.print( fifthNode.getProperty( "title" )  + "\n" );
            System.out.print( fifthNode.getProperty( "author" )  + "\n" );
            System.out.print( fifthNode.getProperty( "year" ) + "\n"  );
            System.out.print( sixthNode.getProperty( "title" )  + "\n" );
            System.out.print( sixthNode.getProperty( "author" )  + "\n" );
            System.out.print( sixthNode.getProperty( "year" ) + "\n"  );
            System.out.print( seventhNode.getProperty( "title" )  + "\n" );
            System.out.print( seventhNode.getProperty( "author" ) + "\n"  );
            System.out.print( seventhNode.getProperty( "year" ) + "\n"  );
            System.out.print( eighthNode.getProperty( "title" ) + "\n"  );
            System.out.print( eighthNode.getProperty( "author" ) + "\n"  );
            System.out.print( eighthNode.getProperty( "year" ) + "\n"  );
            System.out.print( ninthNode.getProperty( "title" )  + "\n" );
            System.out.print( ninthNode.getProperty( "author" ) + "\n"  );
            System.out.print( ninthNode.getProperty( "year" )  + "\n" );
            System.out.print( tenthNode.getProperty( "title" )  + "\n" );
            System.out.print( tenthNode.getProperty( "author" ) + "\n"  );
            System.out.print( tenthNode.getProperty( "year" )  + "\n" );
            
            System.out.print( relationship.getProperty( "message" )  + "\n" );
            System.out.print( relationship2.getProperty( "message" )  + "\n" );
           
            // END SNIPPET: readData

            greeting = ( (String) firstNode.getProperty( "title" ) )
                       + ( (String) relationship.getProperty( "message" ) )
                       + ( (String) secondNode.getProperty( "title" ) );

            // START SNIPPET: transaction
            tx.success();
        }
        // END SNIPPET: transaction
    }

    void removeData()
    {
        try ( Transaction tx = graphDb.beginTx() )
        {
            // START SNIPPET: removingData
            // let's remove the data
            firstNode.getSingleRelationship( RelTypes.KNOWS, Direction.OUTGOING ).delete();
            System.out.println( "Removing firstNode relationship ..." );
            ninthNode.getSingleRelationship( RelTypes.KNOWS, Direction.OUTGOING ).delete();
            System.out.println( "Removing ninthNode relationship ..." );
            firstNode.delete();
            System.out.println( "Removing firstNode  ..." );
            secondNode.delete();
            System.out.println( "Removing secondNode  ..." );
            thirdNode.delete();
            System.out.println( "Removing thridNode ..." );
            fourthNode.delete();
            System.out.println( "Removing fourthNode..." );
            fifthNode.delete();
            System.out.println( "Removing fifthNode..." );
            sixthNode.delete();
            System.out.println( "Removing sixthNode..." );
            seventhNode.delete();
            System.out.println( "Removing seventhNode..." );
            eighthNode.delete();
            System.out.println( "Removing eighthNode..." );
            ninthNode.delete();
            System.out.println( "Removing ninthNode..." );
            tenthNode.delete();
            System.out.println( "Removing tenthNode..." );
            // END SNIPPET: removingData

            tx.success();
        }
    }

    void shutDown()
    {
        System.out.println();
        System.out.println( "Shutting down database ..." );
        // START SNIPPET: shutdownServer
        graphDb.shutdown();
        // END SNIPPET: shutdownServer
    }

    // START SNIPPET: shutdownHook
    private static void registerShutdownHook( final GraphDatabaseService graphDb )
    {
        // Registers a shutdown hook for the Neo4j instance so that it
        // shuts down nicely when the VM exits (even if you "Ctrl-C" the
        // running application).
        Runtime.getRuntime().addShutdownHook( new Thread()
        {
            @Override
            public void run()
            {
                graphDb.shutdown();
            }
        } );
    }
    // END SNIPPET: shutdownHook
}