class Edge {
  constructor(source, destination, weight) {
    this.source = source;
    this.destination = destination;
    this.weight = weight;
  }
}

class Graph {
  constructor(vertices) {
    this.vertices = vertices;
    this.edges = [];
  }

  addEdge(source, destination, weight) {
    this.edges.push(new Edge(source, destination, weight));
  }

  bellmanFord(startVertex) {
    const distances = Array(this.vertices).fill(Infinity);
    distances[startVertex] = 0;

    for (let i = 1; i < this.vertices; i++) {
      for (const edge of this.edges) {
        const { source, destination, weight } = edge;
        if (distances[source] !== Infinity && distances[source] + weight < distances[destination]) {
          distances[destination] = distances[source] + weight;
        }
      }
    }

    for (const edge of this.edges) {
      const { source, destination, weight } = edge;
      if (distances[source] !== Infinity && distances[source] + weight < distances[destination]) {
        return null;
      }
    }

    return distances;
  }
}

const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];
rl.on('line', (line) => {
  if (line.trim() === '0') {
    rl.close();
  } else {
    input.push(line);
  }
});

rl.on('close', () => {
  solveProblem(input);
});

function solveProblem(inp) {
  const cases = parseInt(`${inp[0]}`.trim());
  let iline = 1;
  for (let i = 0; i < cases; i += 1) {
    const lineNM = inp[iline].split(" ").map(item => parseInt(item));
    const n = lineNM[0]
    const m = lineNM[1]
    const vertices = m;
    const graph = new Graph(vertices);
  
    for (let j = 0; j < m; j += 1) {
      iline += 1;
      const lineXYZ = inp[iline].split(" ").map(item => parseInt(item));
      const start = lineXYZ[0]
      const end = lineXYZ[1]
      const weight = lineXYZ[2]

      // Adding edges to the graph
      graph.addEdge(start, end, weight);
    }

    const startVertex = 0;
    const distances = graph.bellmanFord(startVertex);

    if (distances) {
      console.log("not possible")
    } else {
      console.log("possible")
    }

    iline += 1;
  }
}