package mainB;

import java.util.Date;

public class JobPosition {

    private final Date publishedDate;
    private final String title;
    private final boolean isRemote;

    private int yearsOfExperienceRequired;
    private String description;
    private String location;
    private int salary;

    public static class Builder {

        private final Date publishedDate;
        private final String title;
        private final boolean isRemote;


        private String description = "description";
        private String location = "location";
        private int salary = 10000;
        private int yearsOfExperienceRequired = 1;

        public Builder(Date publishedDate, String title, boolean isRemote) {
            this.publishedDate = publishedDate;
            this.title = title;
            this.isRemote = isRemote;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder salary(int salary) {
            this.salary = salary;
            return this;
        }

        public Builder yearsOfExperienceRequired(int yearsOfExperienceRequired) {
            this.yearsOfExperienceRequired = yearsOfExperienceRequired;
            return this;
        }


        public JobPosition build() {
            return new JobPosition(this);
        }
    }

    private JobPosition(Builder builder) {
        this.publishedDate = builder.publishedDate;
        this.title = builder.title;
        this.isRemote = builder.isRemote;

        this.description = builder.description;
        this.location = builder.location;
        this.salary = builder.salary;
        this.yearsOfExperienceRequired = builder.yearsOfExperienceRequired;
    }
}



