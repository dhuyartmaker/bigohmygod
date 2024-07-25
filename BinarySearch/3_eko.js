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
    let line = 0;
    const mn = inp[line].split(" ").map(item => parseInt(item));
    const totalWoodMeter = mn[1];
    let acc = 0;
    let arrs = inp[++line].split(" ").map(item => parseInt(item));
    arrs = arrs.sort((a,b) => a - b)
    console.log('==arrs==', arrs, totalWoodMeter)
    for (let i = arrs.length - 1; i >= 1; i -= 1) {
        acc += (arrs[i] - arrs[i - 1]);
        console.log(acc)
        if (acc >= totalWoodMeter) {
            console.log(arrs[i - 1])
            break;
        }
    }
}