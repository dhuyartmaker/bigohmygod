const PriorityQueue = require("./PriorityQueue");

class Graph {
    constructor() {
        this.nodes = new Set();
        this.adjacencyList = new Map();
    }

    addNode(node) {
        this.nodes.add(node);
        this.adjacencyList.set(node, []);
    }

    addEdge(node1, node2, weight) {
        this.adjacencyList.get(node1).push({ node: node2, weight });
        this.adjacencyList.get(node2).push({ node: node1, weight });
    }

    dijkstra(startNode) {
        const distances = {};
        const visited = new Set();
        const pq = new PriorityQueue();

        this.nodes.forEach(node => {
            distances[node] = Infinity;
        });
        distances[startNode] = 0;

        pq.enqueue({ node: startNode, priority: 0 });

        while (!pq.isEmpty()) {
            const { node: currentNode } = pq.dequeue();

            if (!visited.has(currentNode)) {
                visited.add(currentNode);

                const neighbors = this.adjacencyList.get(currentNode);
                neighbors.forEach(neighbor => {
                    const distance = distances[currentNode] + neighbor.weight;

                    if (distance < distances[neighbor.node]) {
                        distances[neighbor.node] = distance;
                        pq.enqueue({ node: neighbor.node, priority: distance });
                    }
                });
            }
        }

        return distances;
    }
}

// Sử dụng
const graph = new Graph();
graph.addNode('A');
graph.addNode('B');
graph.addNode('C');
graph.addNode('D');
graph.addNode('E');

graph.addEdge('A', 'B', 4);
graph.addEdge('A', 'C', 2);
graph.addEdge('B', 'C', 5);
graph.addEdge('B', 'D', 10);
graph.addEdge('C', 'D', 3);
graph.addEdge('D', 'E', 4);
graph.addEdge('E', 'A', 7);

const distances = graph.dijkstra('A');
console.log(distances);
