package org.drools.benchmark.benchmarks;

import org.drools.benchmark.BenchmarkDefinition;
import org.drools.benchmark.model.Fibonacci;
import org.kie.KnowledgeBase;
import org.kie.runtime.StatefulKnowledgeSession;

public class PlainDRLBenchmark extends AbstractBenchmark {

    private String drlFile;

    private KnowledgeBase kbase;

    public PlainDRLBenchmark(String drlFile) {
        this.drlFile = drlFile;
    }

    @Override
    public void init(BenchmarkDefinition definition) {
        kbase = createKnowledgeBase(createKnowledgeBuilder(drlFile));
    }

    public void execute(int repNr) {
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        ksession.fireAllRules();
        ksession.dispose();
    }
}