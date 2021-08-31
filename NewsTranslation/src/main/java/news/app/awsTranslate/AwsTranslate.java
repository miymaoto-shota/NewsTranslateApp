package news.app.awsTranslate;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClient;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;

public class AwsTranslate {
	
	// 翻訳
	public String TranslateText(String text) {
		AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();

		// AWS設定
		AmazonTranslate translate = AmazonTranslateClient.builder()
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds.getCredentials())).withRegion("us-east-1")
				.build();

		// 翻訳 言語設定
		TranslateTextRequest request = new TranslateTextRequest().withText(text).withSourceLanguageCode("en")
				.withTargetLanguageCode("ja");
		
		TranslateTextResult result = translate.translateText(request);

		return result.getTranslatedText();
	}

}
