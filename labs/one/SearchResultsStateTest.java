import java.util.Scanner;

import org.junit.Test;


public class SearchResultsStateTest {
	
	private AuctionService as = new AuctionService() {
		private Auction dummy = new Auction(1234, "Dummy", 1543, "duh");
		
		@Override
		public Auction[] search(String criteria) {
			return new Auction[] { dummy };
		}

		@Override
		public void bid(String username, Integer itemId) {
			
		}

		@Override
		public Auction create(Auction obj) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Auction retreive(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Auction update(Integer id, Auction obj) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void delete(Integer id) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	@Test 
	public void testBidResponse() {
		
	}
	
	@Test
	public void testSearchResponse() {
		
	}

}
