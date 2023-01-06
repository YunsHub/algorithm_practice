import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static PriorityQueue<Edge> edges;

	static int[] p;
	static int[] rank;

	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int c;

		Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			return this.c - o.c;
		}

	}

	public static void union(int v1, int v2) {
		// 집합은 rank가 낮은 집합을 높은 집합에 결합
		if (rank[v1] > rank[v2]) {
			p[v2] = v1;
		} else {
			p[v1] = v2;
			if (rank[v1] == rank[v2])
				rank[v2]++;
		}
	}

	public static int find(int v) {
		while (p[v] != v) {
			v = p[v];
		}

		return p[v];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		// 간선의 가중치가 낮은 것 부터 정렬할 힙
		edges = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges.add(new Edge(a, b, c));
		}

		// 서로소 집합
		p = new int[N + 1];

		// 자기 자신을 루트로 가지는 집합 생성
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		rank = new int[N + 1]; // rank는 모두 0으로 초기화

		int cnt = 0; // 선택된 간선의 수
		int result = 0; // 선택된 간선의 가중치 합

		// 1. 선택되지 않은 가장 낮은 가중치를 가진 간선 선택
		// 2. 두 정점의 루트가 서로 같지 않다면
		// 2-1. 집합 연결
		while (cnt != N - 1) {
			Edge e = edges.poll();
			if (find(e.a) != find(e.b)) {
				union(find(e.a), find(e.b));
				cnt++;
				result += e.c;
			}
		}

		System.out.print(result);

		br.close();
	}

}