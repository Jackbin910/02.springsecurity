<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.awt.Color" %>
<%@ page import="java.awt.Font" %>
<%@ page import="java.awt.Graphics" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.util.Random" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.io.OutputStream" %>
<%
    int width = 80, height = 32;
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics graphics = image.getGraphics();
    graphics.setColor(new Color(0xDCDCDC));
    graphics.fillRect(0, 0, width, height);
    graphics.setColor(Color.BLACK);
    graphics.drawRect(0, 0, width - 1, height - 1);
    Random random = new Random();
    String hash1 = Integer.toHexString(random.nextInt());
    for (int i = 0; i < 50; i++) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        graphics.drawOval(x, y, 0, 0);
    }
    String capstr = hash1.substring(0, 4);
    session.setAttribute("key", capstr);
    graphics.setColor(new Color(0, 100, 0));
    graphics.setFont(new Font("Candara", Font.BOLD, 24));
    graphics.drawString(capstr, 8, 24);
    graphics.dispose();
    response.setContentType("image/jpeg");
    out.clear();
    out = pageContext.pushBody();
    OutputStream stream = response.getOutputStream();
    ImageIO.write(image, "jpeg", stream);
    stream.close();
%>
