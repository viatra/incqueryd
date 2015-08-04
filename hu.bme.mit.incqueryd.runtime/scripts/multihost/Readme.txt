User: root (sudo -i - after ssh with 'ubuntu' user)

Configure weave:
1. start weave on rm
	weave launch

2. start weave on nodes
	weave launch <RM IP>

Start Cluster:
3. start RM: incqueryd/scripts/start.sh rm -use_ssh
4. start nodes (N - node number 1-N)
	incqueryd/scripts/start.sh N -use_ssh

Now the cluster is ready!

5. start TB:
	trainbenchmark/scripts/run.sh -with_weave

6. Run benchmark:
	source profile.sh
	docker exec $TB_NAME /usr/local/trainbenchmark/run_benchmark.sh <model_size>

