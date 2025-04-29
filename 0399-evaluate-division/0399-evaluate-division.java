class Solution {

    HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String n = equations.get(i).get(0), d = equations.get(i).get(1);

            HashMap<String, Double> nu = graph.getOrDefault(n, new HashMap<>());
            HashMap<String, Double> de = graph.getOrDefault(d, new HashMap<>());

            nu.put(d, values[i]);
            de.put(n, 1.0 / values[i]);

            graph.put(n, nu);
            graph.put(d, de);
        }

        return graph;
    }

    void DFS(HashMap<String, HashMap<String, Double>> graph, String num, String deno, HashSet<String> visited,
            double ans[], double value) {
        visited.add(num);

        if (num.equals(deno)) {
            ans[0] = value;
        } else {
            for (Map.Entry<String, Double> gr : graph.get(num).entrySet()) {
                String n = gr.getKey();
                double val = gr.getValue();

                if (!visited.contains(n)) {
                    DFS(graph, n, deno, visited, ans, value * val);
                }
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double res[] = new double[queries.size()];
        HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);

        for (int i = 0; i < queries.size(); i++) {

            String n = queries.get(i).get(0), d = queries.get(i).get(1);

            if (!graph.containsKey(n) || !graph.containsKey(d)) {
                res[i] = -1.0;
            } else {
                HashSet<String> visited = new HashSet<>();
                double ans[] = { -1.0 };

                DFS(graph, n, d, visited, ans, 1.0);

                res[i] = ans[0];
            }
        }

        return res;
    }

}