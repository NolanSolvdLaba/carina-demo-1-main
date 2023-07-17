package com.zebrunner.carina.demo;

import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.api.GetAllUsersMethod;
import com.zebrunner.carina.demo.api.GetUserMethods;
import com.zebrunner.carina.demo.api.PatchUserMethod;
import com.zebrunner.carina.demo.api.PostUserMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class APIReqRestTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "nolan_geiger")
    public void testCreateUser() {
        LOGGER.info("testCreateUser");

        PostUserMethod api = new PostUserMethod();
        api.setProperties("reqRes_api/users/user.properties");

        LOGGER.info("Sending POST request to create a user");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nolan_geiger")
    public void testCreateUserMissingSomeFields() {
        LOGGER.info("Executing testCreateUserMissingSomeFields");

        PostUserMethod api = new PostUserMethod();
        api.setProperties("reqRes_api/users/user.properties");
        api.getProperties().remove("name");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nolan_geiger")
    public void testGetUser() {
        LOGGER.info("Executing testGetUser");

        GetUserMethods getUserMethods = new GetUserMethods();
        getUserMethods.callAPIExpectSuccess();
        getUserMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUserMethods.validateResponseAgainstSchema("reqRes_api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "nolan_geiger")
    public void testGetAllUsers() {
        LOGGER.info("Executing testGetAllUsers");

        GetAllUsersMethod getAllUsersMethod = new GetAllUsersMethod();
        getAllUsersMethod.callAPIExpectSuccess();
        getAllUsersMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAllUsersMethod.validateResponseAgainstSchema("reqRes_api/users/_get/all_users_rs.schema");
    }

    @Test()
    @MethodOwner(owner = "nolan_geiger")
    public void testPatchUser() {
        LOGGER.info("Executing testPatchUser");

        PatchUserMethod patchUserMethod = new PatchUserMethod();
        patchUserMethod.callAPIExpectSuccess();
        patchUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        patchUserMethod.validateResponseAgainstSchema("reqRes_api/users/_patch/rs.json");
    }
}
