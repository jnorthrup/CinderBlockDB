package kouchdb;

import kouchdb.ann.Optional;
import kouchdb.ann.ProtoNumber;
import kouchdb.ann.ProtoOrigin;

import java.util.List;

@ProtoOrigin(value = "kouchdb.command.CreateDb.CreateOptions")
public interface CreateOptions {

    @Optional(value = 1)
    @ProtoNumber(value = 2)
    boolean getAuto_compaction();


    @Optional(2)
    @ProtoNumber(1)
    String getName();


    @Optional(3)
    @ProtoNumber(3)
    String getCache();


    @Optional(4)
    @ProtoNumber(4)
    String getAdapter();

    @Optional(5)
    @ProtoNumber(5)


    List<CreateOptions> getChallenge();



    @Optional(6)
    @ProtoNumber(6)
    List<String> getChallenge2();


}
