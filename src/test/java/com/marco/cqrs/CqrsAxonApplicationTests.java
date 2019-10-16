package com.marco.cqrs;

import com.marco.cqrs.command.IssueCmd;
import com.marco.cqrs.command.IssuedEvt;
import com.marco.cqrs.command.RedeemCmd;
import com.marco.cqrs.command.RedeemedEvt;
import com.marco.cqrs.model.GiftCard;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CqrsAxonApplicationTests {

	private FixtureConfiguration<GiftCard> fixture;

	@BeforeEach
	void init() {
		fixture = new AggregateTestFixture<>(GiftCard.class);
	}

	@Test
	void createGiftCardTest() {
		fixture.givenNoPriorActivity()
				.when(new IssueCmd("first", 1000L))
				.expectEvents(new IssuedEvt("first", 1000L));
	}

	@Test
	void throwErrorWhenAmountIsZeroOnIssueGiftCard() {
		fixture.givenNoPriorActivity()
				.when(new IssueCmd("first", 0L))
				.expectException(IllegalArgumentException.class);
	}

	@Test
	void redeemGiftCardTest() {
		fixture.given(new IssuedEvt("first", 1000L))
				.when(new RedeemCmd("first", 100L))
				.expectEvents(new RedeemedEvt("first", 100L));
	}

	@Test
	void redeemGiftCardValue() {
		final GiftCard giftCard = new GiftCard();

		giftCard.onIssuedEvent(new IssuedEvt("first", 1000L));
		giftCard.onRedeemEvent(new RedeemedEvt("first", 100L));

		Assertions.assertEquals(900L, giftCard.getCurrentValue());
	}
}
