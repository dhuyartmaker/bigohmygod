const readline = require('readline');

// Tạo interface để đọc dữ liệu từ stdin
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
	const tests = parseInt(inp[0])
	for (let i = 0; i < tests * 2; i += 2) {
		const arrs = inp[i + 1].split(" ").map(item => parseInt(item))
		const n = arrs[0]
		const m = arrs[1]

		const cv = inp[i + 2].split(" ").map(item => parseInt(item))
		printOrder(n, m, cv)
	}
}

class Job {
	constructor(priority, index) {
		this.priority = priority;
		this.index = index;
	}
}

function printOrder(n, m, cv) {
	let priorities = cv

	let queue = [];
	for (let i = 0; i < n; i++) {
		queue.push(new Job(priorities[i], i));
	}

	let time = 0;
	while (queue.length > 0) {
		let currentJob = queue.shift();
		if (queue.some(job => job.priority > currentJob.priority)) {
			queue.push(currentJob);
		} else {
			time++;
			if (currentJob.index === m) {
				console.log(time);
				break;
			}
		}
	}
}
