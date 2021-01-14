package ru.stankin.onit.laba3.entity;

import com.google.gson.annotations.Expose;

import java.util.List;

public class JsonNobelPrize {
    private List<NobelPrize> prizes;

    public List<NobelPrize> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<NobelPrize> prizes) {
        this.prizes = prizes;
    }

    public class NobelPrize {
        @Expose(serialize = false)
        private String parameter1;
        private String year;
        private String category;
        private List<Laureate> laureates;

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public List<Laureate> getLaureates() {
            return laureates;
        }

        public void setLaureates(List<Laureate> laureates) {
            this.laureates = laureates;
        }

        public String getParameter1() {
            return parameter1;
        }

        public void setParameter1(String parameter1) {
            this.parameter1 = parameter1;
        }

        public void setParameter1Null() {
            this.parameter1 = null;
        }
    }


    class Laureate {
        private String id;
        private String firstname;
        private String surname;
        private String motivation;
        private String share;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getMotivation() {
            return motivation;
        }

        public void setMotivation(String motivation) {
            this.motivation = motivation;
        }

        public String getShare() {
            return share;
        }

        public void setShare(String share) {
            this.share = share;
        }
    }
}
