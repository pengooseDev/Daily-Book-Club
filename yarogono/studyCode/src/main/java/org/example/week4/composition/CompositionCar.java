package org.example.week4.composition;

class Engine {
    public void work() { }
}


// Aggregation
class AggregationCar {
    private Engine engine;

    void setEngine(Engine engine) {
        this.engine = engine;
    }

    void move() {
        if (engine != null)
            engine.work();
    }
}

// Dependency
class DependencyCar {
    private Engine engine;

    // constructor
    public DependencyCar( Engine engine ) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return this.engine;
    }
    public void setAddress( Engine engine ) {
        this.engine = engine;
    }
}

// Composition
public class CompositionCar {
    private final Engine engine;

    public CompositionCar() {
        engine = new Engine();
    }

    void move() {
        engine.work();
    }
}