package dk.via.sdj3.assignment.Server.AppConnection;

import dk.via.sdj3.assignment.Server.DBConnection.SQL;

public class SlaughterhouseServiceImplBuilder {
    private SQL sql;

    public SlaughterhouseServiceImplBuilder setSql(SQL sql) {
        this.sql = sql;
        return this;
    }

    public SlaughterhouseServiceImpl createSlaughterhouseServiceImpl() {
        return new SlaughterhouseServiceImpl(sql);
    }
}