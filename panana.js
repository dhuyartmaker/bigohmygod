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
	console.log(solveProblem(input));
});

function solveProblem(inp) {
    const n = `${inp}`.trim().split(" ").map(i => parseInt(i))
    console.log(n);
    let count = 0
    const k = n[0];
	for (let i = 0; i < n[2]; i += 1) {
        count += ((i + 1) * k)
    }

    if (count <= 0) {
        return 0
    }

    return count - n[1];
}