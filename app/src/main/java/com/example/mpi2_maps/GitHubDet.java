package com.example.mpi2_maps;

import android.os.Parcel;
import android.os.Parcelable;

public class GitHubDet implements Parcelable {

    private String name;
    private Owner owner;

    public  GitHubDet(){

    }

    public GitHubDet(String name, Owner owner) {
        this.name = name;
        this.owner = owner;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    protected GitHubDet(Parcel in) {
        String[] data = new String[2];
        in.readStringArray(data);
        this.name = data[0];
        this.owner = new Owner(data[1]);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{this.name, this.owner.getLogin()});
    }

    public static final Creator<GitHubDet> CREATOR = new Creator<GitHubDet>() {
        @Override
        public GitHubDet createFromParcel(Parcel in) {
            return new GitHubDet(in);
        }

        @Override
        public GitHubDet[] newArray(int size) {
            return new GitHubDet[size];
        }
    };

    public class Owner {

        public Owner() {

        }

        public Owner(String login) {
            setLogin(login);
        }

        private String login;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

    }
}

