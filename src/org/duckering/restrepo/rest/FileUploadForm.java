package org.duckering.restrepo.rest;

import javax.ws.rs.FormParam;

/**
 * Created by IntelliJ IDEA.
 * User: tduckerin
 * Date: Apr 6, 2011
 * Time: 1:56:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileUploadForm {
    private byte[] filedata;
    private String name;

    public FileUploadForm() {}

    @FormParam("name")
    public void setPath(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public byte[] getFileData() {
        return filedata;
    }

    @FormParam("filedata")
    //@PartType("application/octet-stream")
    public void setFileData(final byte[] filedata) {
        this.filedata = filedata;
    }
}