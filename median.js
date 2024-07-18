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
    const arrs = `${inp[1]}`.trim().split(" ").map(i => parseInt(i))
    const sortArr = arrs.sort((a,b) => a - b)
    return sortArr[Math.floor((sortArr.length / 2))]
}