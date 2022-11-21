package dk.via.sdj3.assignment.Server.AppConnection;

import dk.via.sdj3.assignment.Server.DBConnection.SQL;
import io.grpc.Server;
import io.grpc.ServerBuilder;



public class RunServer {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    //User and password should be change to each Postgres configuration!!
    private static final String USER = "postgres";
    private static final String PASSWORD = "041199";
    private static final String schema = "slaughterhouse";

    public static void main(String[] args) throws Exception
    {
        //SQL class connection with the final attributes as parameters
        SQL sql = new SQL(URL, USER, PASSWORD, schema);

        //New server object is created on the 9090 port
        Server server = ServerBuilder.forPort(1010)
                .addService(new SlaughterhouseServiceImplBuilder().setSql(sql).createSlaughterhouseServiceImpl()) //Adding a grpc service to the server port
                .build(); //Building the server with the added services
        server.start(); //Starts the server
        server.awaitTermination(); //Awaits server termination so that the server doesn't instantly close when started
    }
}
