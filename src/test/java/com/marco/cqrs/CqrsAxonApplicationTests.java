package com.marco.cqrs;

import com.marco.cqrs.command.IssueCmd;
import com.marco.cqrs.command.IssuedEvt;
import com.marco.cqrs.command.RedeemCmd;
import com.marco.cqrs.command.RedeemedEvt;
import com.marco.cqrs.model.GiftCard;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CqrsAxonApplicationTests {

	private FixtureConfiguration<GiftCard> fixture;

	@Before
	public void init() {
		fixture = new AggregateTestFixture<>(GiftCard.class);
	}

	@Test
	public void createGiftCardTest() {
		fixture.givenNoPriorActivity()
				.when(new IssueCmd("first", 1000L))
				.expectEvents(new IssuedEvt("first", 1000L));
	}

	@Test
	public void throwErrorWhenAmountIsZeroOnIssueGiftCard() {
		fixture.givenNoPriorActivity()
				.when(new IssueCmd("first", 0L))
				.expectException(IllegalArgumentException.class);
	}

	@Test
	public void redeemGiftCardTest() {
		fixture.given(new IssuedEvt("first", 1000L))
				.when(new RedeemCmd("first", 100L))
				.expectEvents(new RedeemedEvt("first", 100L));
	}

	@Test
	public void redeemGiftCardValue() {
		final GiftCard giftCard = new GiftCard();

		giftCard.onIssuedEvent(new IssuedEvt("first", 1000L));
		giftCard.onRedeemEvent(new RedeemedEvt("first", 100L));

		Assert.assertEquals(900L, giftCard.getCurrentValue());
	}



}
