package creationalpatterns.builder;

/**
 * The product class representing a House.
 */
public class House {
    private final String foundation;
    private final String walls;
    private final String roof;
    private final String interior;

    // Private constructor to enforce the use of the Builder
    private House(Builder builder) {
        this.foundation = builder.foundation;
        this.walls = builder.walls;
        this.roof = builder.roof;
        this.interior = builder.interior;
    }

    // Getters for all fields
    public String getFoundation() {
        return foundation;
    }

    public String getWalls() {
        return walls;
    }

    public String getRoof() {
        return roof;
    }

    public String getInterior() {
        return interior;
    }

    // Builder static nested class
    public static class Builder {
        private String foundation;
        private String walls;
        private String roof;
        private String interior;

        public Builder setFoundation(String foundation) {
            this.foundation = foundation;
            return this; // Allow method chaining
        }

        public Builder setWalls(String walls) {
            this.walls = walls;
            return this;
        }

        public Builder setRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public Builder setInterior(String interior) {
            this.interior = interior;
            return this;
        }

        // Method to build the House object
        public House build() {
            return new House(this);
        }
    }
}
