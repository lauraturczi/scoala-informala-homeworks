package siit.h9;

public enum TicketType {
	FULL {
		@Override
		public int increment(int i) {
			return i++;
		}

	},
	FULL_VIP {
		@Override
		public int increment(int i) {
			return i++;
		}
	},
	FREE_PASS {
		@Override
		public int increment(int i) {
			return i++;
		}
	},
	ONE_DAY {
		@Override
		public int increment(int i) {
			return i++;
		}
	},
	ONE_DAY_VIP {
		@Override
		public int increment(int i) {
			return i++;
		}
	};

	public abstract int increment(int i);

}
